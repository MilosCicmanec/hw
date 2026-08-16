#include <bits/stdc++.h>
#include <cstdint>
#include <fstream>
#include <iostream>
#include <unistd.h>
#include <vector>

using namespace std;
using vi = vector<int>;
using ll = long long;
using vl = vector<long long>;

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
};

#pragma pack(pop)

// global variables
Superblock sb;
fstream file;
// write bin will work but only for simple data structs like int float etc
template <typename T> void write_bin(fstream &fs, const T &data) {
  fs.write(reinterpret_cast<const char *>(&data), sizeof(T));
}

void sup_init() {
  memset(sb.name, 0, sizeof(sb.name));
  strncpy(sb.name, "MyFs", sizeof(sb.name) - 1);

  sb.block_count = 1024;
  sb.block_size = 512;
  sb.fat_start_block = 1;

  ll tmp = (sb.block_count * 4 + (sb.block_size - 1)) / sb.block_size;
  sb.data_start_block = tmp + 1;
}
int open_file(const string &filename) {
  file.open(filename, ios::in | ios::out | ios::binary);
  if (!file.is_open()) {
    return 1;
  }
  return 0;
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

int main() {
  // disk init
  if (open_file("archive.bin") == 0) {
    cout << "File opened" << endl;
  } else {
    cout << "File opening error" << endl;
  }
  sup_init();
  wipe_disk(); // this should probably be optional
  fat_init();

  // write the sperblock data onto the disk
  file.seekp(0);
  write_bin(file, sb);
  file.flush();

  return 0;
}
