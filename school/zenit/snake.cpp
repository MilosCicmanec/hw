#include <bits/stdc++.h>
#include <vector>

using namespace std;
using vi = vector<int>;
using ll = long long;
using vl = vector<long long>;

void solve() {
  ll mod = 1000000007;
  int random_number = 0;
  string s;
  srand(time(0));
  while (true) {
    random_number = rand() % 4;
    cin >> s;
    if (s == "?") {
      if (random_number == 0) {
        cout << "^" << endl;
      } else if (random_number == 1) {
        cout << "v" << endl;
      } else if (random_number == 2) {
        cout << ">" << endl;
      } else if (random_number == 3) {
        cout << "<" << endl;
      }
    } else if (s == ".") {
      return;
    }
  }
  int e;
}

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);

  int t = 1;
  while (t--)
    solve();
  return 0;
}
