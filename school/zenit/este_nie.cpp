#include <bits/stdc++.h>
#include <cmath>
#include <vector>

using namespace std;
using vi = vector<int>;
using ll = long long;
using vl = vector<long long>;

void solve() {
  ll mod = 1000000007;
  int n;
  cin >> n;
  int tmp;
  int sum = 0;
  for (int i = 0; i < 50; i++) {
    tmp = n;
    sum = 0;
    while (tmp > 0) {
      sum += pow(tmp % 10, 2);
      tmp -= tmp % 10;
      tmp /= 10;
    }
    n = sum;
    if (sum == 1) {
      cout << i + 1 << endl;
      return;
    }
  }
  cout << -1 << endl;
}

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);

  int t;
  cin >> t;
  while (t--)
    solve();
  return 0;
}
