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
  sb.block_count = 1024;
  sb.block_size = 512;
  sb.fat_start_block = 1;

  ll tmp = (sb.block_count * 4 + (sb.block_size - 1)) / sb.block_size;
  sb.data_start_block = tmp + 1;
};
int open_file(const string &filename) {
  file.open(filename, ios::in | ios::out | ios::binary);
  if (!file.is_open()) {
    return 1;
  }
  return 0;
}
int main() {
  if (open_file("archive.bin") == 0) {
    cout << "File opened" << endl;
  } else {
    cout << "File opening error" << endl;
  }

  return 0;
}
