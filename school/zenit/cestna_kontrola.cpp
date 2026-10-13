#include <bits/stdc++.h>
#include <cctype>
#include <vector>

using namespace std;
using vi = vector<int>;
using ll = long long;
using vl = vector<long long>;

bool letter(char c) {
  if (int(c) >= 65 && int(c) <= 90) {
    return true;
  }
  return false;
}
bool number(char c) {
  if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' ||
      c == '6' || c == '7' || c == '8' || c == '9') {
    return true;
  }
  return false;
}
void solve() {
  ll mod = 1000000007;
  string s;
  cin >> s;
  if (s.length() != 7) {
    cout << "Nie" << endl;
    return;
  }
  bool valid = true;
  if (letter(s[0]) && letter(s[1]) && number(s[2]) && number(s[3]) &&
      number(s[4]) && letter(s[5]) && letter(s[6])) {
    cout << "Ano" << endl;
    return;
  }
  cout << "Nie" << endl;
}

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);

  int t = 1;

  while (t--)
    solve();
  return 0;
}
