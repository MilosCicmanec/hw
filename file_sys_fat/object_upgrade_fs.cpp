#include <cstdint>
#include <fstream>
#include <iostream>
#include <sstream>
#include <vector>

using namespace std;

#pragma pack(push, 1)
const int32_t BLOCK_EMPTY = -2;
const int32_t BLOCK_EOF = -1;
const int32_t BLOCK_X = -3;

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

class Shell {
public:
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
        // cm_ls();
      }

      else if (command == "mkdir") {
        string dirname;

        if (ss >> dirname) {
          // cm_mkdir(dirname);
        } else {
          cout << "Usage: mkdir <directory_name>" << endl;
        }
      }

      else if (command == "load") {
        string filename;

        if (ss >> filename) {
          // load_file(filename);
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
            // delete_entry(cur_dir, filename);
            // file.flush();
          }
        } else {
          cout << "Usage: rm <filename>" << endl;
        }
      } else if (command == "cd") {
        string dirname;

        if (ss >> dirname) {
          // cm_cd(dirname);
        } else {
          cout << "Usage: cd <directory_name>" << endl;
        }
      }

      else {
        cout << "Unknown command: " << command << endl;
      }
    }
  }
};

class BlockDevice {
private:
  fstream file;

public:
  template <typename T> void write_bin(const T &data) {
    file.write(reinterpret_cast<const char *>(&data), sizeof(T)); //[cite: 1]
  }

  template <typename T> void read_bin(T &data) {
    file.read(reinterpret_cast<char *>(&data), sizeof(T)); //[cite: 1]
  }
  void seekg(streampos pos) { file.seekg(pos); }
  void seekp(streampos pos) { file.seekp(pos); }
  void flush() { file.flush(); }
  void close() { file.close(); }
  bool is_open() { return file.is_open(); }
  void wipe_disk(uint32_t block_count, uint32_t block_size) {
    file.seekp(0);
    vector<char> zero_block(block_size, 0);
    for (uint32_t i = 0; i < block_count; i++) {
      file.write(zero_block.data(), block_size);
    }
    file.flush();
    cout << "Disk cleaned successfully" << endl;
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
      return 0;
    }
    return 0;
  }
};

class FatTable {
private:
  BlockDevice &disk;
  Superblock &sb;

public:
  // this is needed because in my older file i used global variables but now i
  // cant
  FatTable(BlockDevice &disk_device, Superblock &superblock)
      : disk(disk_device), sb(superblock) {}
  // writes a new value to the fat table for a specific block
  void set_fat_entry(uint32_t block_index, int32_t value) {
    disk.seekp((sb.fat_start_block * sb.block_size) +
               (block_index * sizeof(uint32_t)));
    disk.write_bin(value);
  }
  int32_t current_fat_entry(uint32_t block_index) {
    int32_t value;
    disk.seekg((sb.fat_start_block * sb.block_size) +
               (block_index * sizeof(uint32_t)));
    disk.read_bin(value);
    return value;
  }
  void fat_init() {
    disk.seekp(sb.fat_start_block * sb.block_size);
    for (int i = 0; i < sb.block_count; i++) {
      if (i < sb.data_start_block) {
        disk.write_bin(BLOCK_X);
      } else {
        disk.write_bin(BLOCK_EMPTY);
      }
    }
  }
  int alloc_block() {
    for (uint32_t i = sb.data_start_block; i < sb.block_count; i++) {
      if (current_fat_entry(i) == BLOCK_EMPTY) {
        set_fat_entry(i, BLOCK_EOF);
        return i;
      }
    }
    return -1;
  }
  void rm_file(uint32_t starting_block) {
    int32_t x = current_fat_entry(starting_block);
    if (x != BLOCK_EOF) {
      rm_file(x);
    }
    set_fat_entry(starting_block, BLOCK_EMPTY);
  }
};
