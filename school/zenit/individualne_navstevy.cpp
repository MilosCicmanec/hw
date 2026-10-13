#include <bits/stdc++.h>
#include <vector>

using namespace std;
using vi = vector<int>;
using ll = long long;
using vl = vector<long long>;

void solve() {
  ll mod = 1000000007;
  int n;
  cin >> n;
  vl dates(n, 0);
  for (int i = 0; i < n; i++) {
    cin >> dates[i];
    // dates[i] = dates[i] - 1;
  }
  ll t = 1;
  int res = 0;
  sort(dates.begin(), dates.end());
  for (int i = 0; i < n; i++) {
    cout << dates[i] << " " << t << " " << res << endl;
    if (dates[i] == t) {
      t++;
    } else if (dates[i] < t) {
      res = res + t - dates[i];
      t++;
    } else { // dates[i] > time
    }
    cout << res << endl;
  }
  cout << res << endl;
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
