#include <cstdint>
#include <cstring>
#include <exception>
#include <filesystem>
#include <fstream>
#include <iostream>

#include <set>

#include <sstream>
#include <vector>

using namespace std;
using ll = long long;

const int32_t BLOCK_EMPTY = -2;
const int32_t BLOCK_EOF = -1;
const int32_t BLOCK_X =
    -3; // this will mark blocks such as superblock and fat table as not usable

#pragma pack(push, 1)

struct Superblock {
  char name[32];
  uint32_t block_count;
  uint32_t block_size; // in bytes
  uint32_t fat_start_block;
  uint32_t data_start_block;
  uint32_t root_start_block;
};

struct DirEntry {
  uint8_t is_used;      // 0 empty 1 full
  char name[54];        // 54 bytes
  uint8_t is_dir;       // 1 folder 0 file
  uint32_t start_block; // the first block in fat
  uint32_t size;        // file size in bytes
};

#pragma pack(pop)

// global variables
Superblock sb;
fstream file;
uint32_t cur_dir;
// write bin will work but only for simple data structs like int float etc
template <typename T> void write_bin(fstream &fs, const T &data) {
  fs.write(reinterpret_cast<const char *>(&data), sizeof(T));
}
template <typename T> void read_bin(fstream &fs, T &data) {
  fs.read(reinterpret_cast<char *>(&data), sizeof(T));
}
// writes a new value to the fat table for a specific block
void set_fat_entry(uint32_t block_index, int32_t value) {
  file.seekp((sb.fat_start_block * sb.block_size) +
             (block_index * sizeof(uint32_t)));
  write_bin(file, value);
}
// reads what the fat table value is for a specific block
int32_t current_fat_entry(uint32_t block_index) {
  int32_t value;
  file.seekg((sb.fat_start_block * sb.block_size) +
             (block_index * sizeof(uint32_t)));
  read_bin(file, value);
  return value;
}
void sup_init() {
  memset(sb.name, 0, sizeof(sb.name));
  strncpy(sb.name, "MyFs", sizeof(sb.name) - 1);

  sb.block_count = 1024;
  sb.block_size = 512;
  sb.fat_start_block = 1;

  uint32_t tmp = (sb.block_count * 4 + (sb.block_size - 1)) / sb.block_size;
  sb.data_start_block = tmp + 1;
}
void wipe_disk() {
  file.seekp(0);
  vector<char> zero_block(sb.block_size, 0);
  for (int i = 0; i < sb.block_count; i++) {
    file.write(zero_block.data(), sb.block_size);
  };
  file.flush();
  cout << "Disk zeroed out completely" << endl;
}
void fat_init() {
  file.seekp(sb.fat_start_block * sb.block_size);
  for (int i = 0; i < sb.block_count; i++) {
    if (i < sb.data_start_block) {
      write_bin(file, BLOCK_X);
    } else {
      write_bin(file, BLOCK_EMPTY);
    }
  }
}
int alloc_block() {
  // file.seekg(sb.fat_start_block * sb.block_size);
  // int32_t current_fat_entry;
  // for (uint32_t i = 0; i < sb.block_count; i++) {
  //   read_bin(file, current_fat_entry);
  //   if (current_fat_entry == BLOCK_EMPTY) {
  //     return i;
  //   }
  for (uint32_t i = sb.data_start_block; i < sb.block_count; i++) {
    if (current_fat_entry(i) == BLOCK_EMPTY) {
      set_fat_entry(i, BLOCK_EOF);
      return i;
    }
  }
  return -1;
}
void root_init() {
  int32_t root_block = alloc_block();
  if (root_block == -1) {
    cout << "disk full" << endl;
    return;
  }
  sb.root_start_block = root_block;
  // file.seekp((sb.fat_start_block * sb.block_size) + (root_block *
  // sizeof(uint32_t))); write_bin(file, BLOCK_EOF);
  DirEntry entries[8]; // 8 * 64 bytes = 512 bytes
  memset(entries, 0, sizeof(entries));
  // init . (cur dir)
  entries[0].is_used = 1;
  strncpy(entries[0].name, ".", 53);
  entries[0].is_dir = 1;
  entries[0].start_block = root_block;
  entries[0].size = 0;
  // init .. (parent dir)
  entries[1].is_used = 1;
  strncpy(entries[1].name, "..", 53);
  entries[1].is_dir = 1;
  entries[1].start_block = root_block;
  entries[1].size = 0;
  file.seekp(root_block * sb.block_size);
  write_bin(file, entries);
}
bool try_insert_in_block(uint32_t block_index, DirEntry new_entry) {
  DirEntry entries[8];
  file.seekg(block_index * sb.block_size);
  read_bin(file, entries);
  for (int i = 0; i < 8; i++) {
    if (entries[i].is_used == 0) {
      entries[i] = new_entry;
      file.seekp(block_index * sb.block_size);
      write_bin(file, entries);
      return true;
    }
  }
  return false;
}
void expand_dir(uint32_t last_block, DirEntry new_entry) {
  int32_t new_block = alloc_block();
  if (new_block == -1) {
    cout << "disk full" << endl;
    return;
  }
  set_fat_entry(last_block, new_block);
  DirEntry new_block_entries[8];
  memset(new_block_entries, 0, sizeof(new_block_entries));
  new_block_entries[0] = new_entry;
  file.seekp(new_block * sb.block_size);
  write_bin(file, new_block_entries);
}
void add_entry_dir(uint32_t dir_start_block, DirEntry new_entry) {
  uint32_t current_block = dir_start_block;
  int32_t next_block;

  while (true) {
    if (try_insert_in_block(current_block, new_entry)) {
      return;
    }
    next_block = current_fat_entry(current_block);
    if (next_block == BLOCK_EOF) {
      break;
    } else {
      current_block = next_block;
    }
  }
  expand_dir(current_block, new_entry);
}
bool entry_exists(uint32_t dir_start_block, const string &name) {
  uint32_t current_block = dir_start_block;
  DirEntry entries[8];
  while (true) {
    file.seekg(current_block * sb.block_size);
    read_bin(file, entries);
    for (int i = 0; i < 8; i++) {
      if (entries[i].is_used && name == entries[i].name) {
        return true;
      }
    }
    int32_t next_block = current_fat_entry(current_block);
    if (next_block == BLOCK_EOF || next_block < 0) {
      break;
    }
    current_block = next_block;
  }
  return false;
}
void cm_mkdir(string name) {
  if (entry_exists(cur_dir, name)) {
    cout << "dir already exists" << endl;
    return;
  }
  int32_t dir_block = alloc_block();
  if (dir_block == -1) {
    cout << "disk full" << endl;
    return;
  }
  // file.seekp((sb.fat_start_block * sb.block_size) +
  //            (dir_block * sizeof(uint32_t)));
  // write_bin(file, BLOCK_EOF);
  DirEntry entries[8];
  memset(entries, 0, sizeof(entries));
  // init "." (cur dir)
  entries[0].is_used = 1;
  strncpy(entries[0].name, ".", 53);
  entries[0].is_dir = 1;
  entries[0].start_block = dir_block;
  entries[0].size = 0;
  // parent dir ".."
  entries[1].is_used = 1;
  strncpy(entries[1].name, "..", 53);
  entries[1].is_dir = 1;
  entries[1].start_block = cur_dir;
  entries[1].size = 0;
  file.seekp(dir_block * sb.block_size);
  write_bin(file, entries);
  DirEntry new_folder_entry;
  memset(&new_folder_entry, 0, sizeof(DirEntry));
  new_folder_entry.is_used = 1;
  strncpy(new_folder_entry.name, name.c_str(), 53);
  new_folder_entry.is_dir = 1;
  new_folder_entry.start_block = dir_block;
  new_folder_entry.size = 0;

  add_entry_dir(cur_dir, new_folder_entry);
  file.flush();
}
void sys_init() {
  sup_init();
  wipe_disk();
  fat_init();
  root_init();

  // write the sperblock data onto the disk
  file.seekp(0);
  write_bin(file, sb);
  file.flush();
  cout << "System initialized" << endl;
}
int open_file(const string &filename) {
  file.open(filename, ios::in | ios::out | ios::binary);
  if (!file.is_open()) {
    file.clear();
    file.open(filename, ios::out | ios::binary);
    file.close();
    file.open(filename, ios::in | ios::out | ios::binary);
    if (!file.is_open())
      return 1;
    sys_init();

    return 0;
  }
  file.seekg(0);
  read_bin(file, sb);
  if (strncmp(sb.name, "MyFs", sizeof(sb.name)) != 0) {
    sys_init();
  }
  return 0;
}
void cm_ls() {
  uint32_t current_block = cur_dir;
  DirEntry entries[8];
  while (true) {
    file.seekg(current_block * sb.block_size);
    read_bin(file, entries);
    for (int i = 0; i < 8; i++) {
      if (entries[i].is_used == 1) {
        if (entries[i].is_dir) {
          cout << "[DIR] ";
        } else {
          cout << "[FILE] ";
        }
        cout << entries[i].name << "\t " << entries[i].size << " B" << endl;
      }
    }
    int32_t next_block = current_fat_entry(current_block);
    if (next_block == BLOCK_EOF || next_block < 0) {
      break;
    }
    current_block = next_block;
  }
}

void save_file(const vector<unsigned char> &data, const string &filename);
bool load_file(string filename) {
  ifstream file_to_load(filename, ios::binary);
  if (!file_to_load.is_open()) {
    cout << "Error opening file: " << filename << endl;
    return false;
  }
  file_to_load.seekg(0, ios::end);
  size_t dataLength = file_to_load.tellg();
  file_to_load.seekg(0, ios::beg);

  vector<unsigned char> buffer(dataLength);
  // we cannot use read_bin because the size is dynamic (if we passed a pointer
  // it sizeof(T) would just measure size of the pointer not the alocated
  // memory)
  file_to_load.read(reinterpret_cast<char *>(buffer.data()), dataLength);
  cout << "File loaded successfully: " << filename << endl;
  save_file(buffer, filename);
  return true;
}
void save_file(const vector<unsigned char> &data, const string &filename) {
  if (entry_exists(cur_dir, filename)) {
    cout << "Entry already exists" << endl;
    return;
}


  if (data.empty())
    return;

  int32_t size = data.size();
  int32_t num_blocks = (size + sb.block_size - 1) / sb.block_size;
  int32_t num_free_blocks = 0;
  bool enough_space = false;
  for (uint32_t i = sb.data_start_block; i < sb.block_count; i++) {
    if (current_fat_entry(i) == BLOCK_EMPTY) {
      num_free_blocks++;
      if (num_free_blocks >= num_blocks) {
        enough_space = true;
        break;
      }
    }
  }
  if (!enough_space) {
    cout << "Error: Not enough space on disk!" << endl;
    return;
  }
  int32_t previous_block = -1;
  int32_t first_block = -1; // this is needed for saving the dir entry

  for (int i = 0; i < num_blocks; i++) {
    int32_t current_block = alloc_block();

    if (previous_block != -1) {

      set_fat_entry(previous_block, current_block);
    } else {
      // remember the very fist block
      first_block = current_block;
    }
    previous_block = current_block;
    file.seekp(current_block * sb.block_size);
    int bytes_to_write = sb.block_size;
    if (i == num_blocks - 1) { // if its the last block
      bytes_to_write = size - (i * sb.block_size);
    }
    file.write(
        reinterpret_cast<const char *>(data.data() + (i * sb.block_size)),
        bytes_to_write);
  }
  // create dir entry for the file
  DirEntry new_entry;
  memset(&new_entry, 0, sizeof(DirEntry));
  new_entry.is_used = 1;
  strncpy(new_entry.name, filename.c_str(), 53);
  new_entry.is_dir = 0;
  new_entry.start_block = first_block;
  new_entry.size = size;
  add_entry_dir(cur_dir, new_entry);
  file.flush();
  cout << "File " << filename << " saved." << endl;
}
void rm_file(uint32_t starting_block){
  int32_t x = current_fat_entry(starting_block);
  if (x != BLOCK_EOF)
  {
    rm_file(x);
  }
  set_fat_entry(starting_block, BLOCK_EMPTY);
}
void rm_dir(uint32_t starting_block);

bool delete_entry(uint32_t dir_start_block, const string &name) {
  uint32_t current_block = dir_start_block;
  DirEntry entries[8];
  while (true) {
    file.seekg(current_block * sb.block_size);
    read_bin(file, entries);
    for (int i = 0; i < 8; i++) {
      if (entries[i].is_used && name == entries[i].name) {
        if (entries[i].is_dir)
        {
          rm_dir(entries[i].start_block);
        } else {
          rm_file(entries[i].start_block);
        }
        memset(&entries[i], 0 , sizeof(DirEntry));
        file.seekp(current_block * sb.block_size);
        write_bin(file, entries);

        return true;
      }
    }
    int32_t next_block = current_fat_entry(current_block);
    if (next_block == BLOCK_EOF || next_block < 0) {
      break;
    }
    current_block = next_block;
  }
  return false;
}

void rm_dir(uint32_t starting_block) {
    uint32_t current_block = starting_block;
    DirEntry entries[8];

    while (true) {
        file.seekg(current_block * sb.block_size);
        read_bin(file, entries);

        for (int i = 0; i < 8; i++) {
            if (!entries[i].is_used) {
                continue;
            }

            // Ignore . and ..
            if (strcmp(entries[i].name, ".") == 0 ||
                strcmp(entries[i].name, "..") == 0) {
                continue;
            }

            if (entries[i].is_dir == 0) {
                // It's a file
                rm_file(entries[i].start_block);
            } 
            else {
                // It's a directory
                rm_dir(entries[i].start_block);
            }
        }

        int32_t next_block = current_fat_entry(current_block);

        if (next_block == BLOCK_EOF) {
            break;
        }

        current_block = next_block;
    }

    // free the dirs starting blocks
    rm_file(starting_block);
}

void run_console() {
  string line;

  while (true) {
    cout << "MyFs> ";

    if (!getline(cin, line)) {
      break;
    }

    stringstream ss(line);
    string command;
    ss >> command;

    if (command.empty()) {
      continue;
    }

    if (command == "exit") {
      break;
    }

    else if (command == "ls") {
      cm_ls();
    }

    else if (command == "mkdir") {
      string dirname;

      if (ss >> dirname) {
        cm_mkdir(dirname);
      } else {
        cout << "Usage: mkdir <directory_name>" << endl;
      }
    }

    else if (command == "load") {
      string filename;

      if (ss >> filename) {
        load_file(filename);
      } else {
        cout << "Usage: load <filename>" << endl;
      }
    }

    else if (command == "rm") {
      string filename;

      if (ss >> filename) {
        if (filename == "." || filename == "..") {
          cout << "Cannot remove . or .." << endl;
        } else {
          delete_entry(cur_dir, filename);
          file.flush();
        }
      } else {
        cout << "Usage: rm <filename>" << endl;
      }
    }

    else {
      cout << "Unknown command: " << command << endl;
    }
  }
}
int main() {
  // disk init
  if (open_file("archive.bin") == 0) {
    cout << "File opened" << endl;
  } else {
    cout << "File opening error" << endl;
  }
  // sup_init();
  cur_dir = sb.root_start_block;
  run_console();
  if (file) {
    file.close();
  }
  return 0;
}
