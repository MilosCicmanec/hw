#include <bits/stdc++.h>
#include <cstdint>
#include <fstream>
#include <iostream>
#include <vector>

using namespace std;
using vi = vector<int>;
using ll = long long;
using vl = vector<long long>;

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

int main() {
  // disk init
  if (open_file("archive.bin") == 0) {
    cout << "File opened" << endl;
  } else {
    cout << "File opening error" << endl;
  }
  sup_init();
  wipe_disk(); // this should probably be optional

  // write the sperblock data onto the disk
  file.seekp(0);
  file.write(reinterpret_cast<char *>(&sb), sizeof(Superblock));
  file.flush();

  return 0;
}
