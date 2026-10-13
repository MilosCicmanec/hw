#include <bits/stdc++.h>
#include <climits>
#include <vector>

using namespace std;
using vi = vector<int>;
using ll = long long;
using vl = vector<long long>;

void solve() {
  ll mod = 1000000007;
  int n;
  cin >> n;
  ll b = INT_MIN;
  ll sb = INT_MIN;
  ll tmp;
  for (int i = 0; i < n; i++) {
    cin >> tmp;
    if (tmp > b) {
      sb = b;
      b = tmp;
    } else if (tmp > sb) {
      sb = tmp;
    }
  }
  cout << b << " " << sb << endl;
}

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);

  int t;
  t = 1;
  while (t--)
    solve();
  return 0;
}
