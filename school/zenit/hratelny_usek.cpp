#include <bits/stdc++.h>
#include <vector>

using namespace std;
using vi = vector<int>;
using ll = long long;
using vl = vector<long long>;
int p1(string s, int ptx) {
  ptx++;
  while (s[ptx] != 'p') {
    ptx++;
  }
  return ptx;
}
int p2(string s, int ptx) {
  ptx--;
  while (s[ptx] != 'p') {
    ptx--;
  }
  return ptx;
}
void solve() {
  ll mod = 1000000007;
  int n;
  cin >> n;
  string s;
  cin >> s;
  int ptr1 = p1(s, -1);
  int ptr2 = p2(s, n);

  while (true) {
    if (ptr1 == ptr2) {
      if (s[ptr1] == 'p') {
        cout << 1 << endl;
        return;
      } else {
        cout << 0 << endl;
        return;
      }
    } else if (ptr1 > ptr2) {
      cout << 0 << endl;
      return;
    }
  }
}

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);

  int t = 1;
  while (t--)
    solve();
  return 0;
}
