#include <bits/stdc++.h>
#include <vector>

using namespace std;
using vi = vector<int>;
using ll = long long;
using vl = vector<long long>;

void solve() {
  ll mod = 1000000007;
  ll p, n;
  cin >> p >> n;
  vl cap(n, 0);
  for (int i = 0; i < n; i++) {
    cin >> cap[i];
  }
  vl holding(n, 0);
  vl score(n, 0);
  bool empty;
  while (true) {
    empty = true;
    for (int i = 0; i < n; i++) {
      if (holding[i] > 0) {
        score[i] = score[i] + 1;
        holding[i] = holding[i] - 1;
      } else {
        if (p >= cap[i]) {
          holding[i] = holding[i] + cap[i];
          p -= cap[i];
        } else {
          holding[i] = holding[i] + p;
          p = 0;
        }
      }
      if (holding[i] > 0 || p > 0) {
        empty = false;
      }
      // cout << cap[i] << " " << holding[i] << " " << score[i] << endl;
    }
    if (empty) {
      break;
    }
  }
  int maximum = INT_MIN;
  int idx = 0;
  for (int i = 0; i < n; i++) {
    if (maximum < score[i]) {
      idx = i;
      maximum = score[i];
    }
  }
  cout << idx << endl;
}

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);

  int t = 1;
  while (t--)
    solve();
  return 0;
}
