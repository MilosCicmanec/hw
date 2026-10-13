#include <bits/stdc++.h>
#include <vector>

using namespace std;
using vi = vector<int>;
using ll = long long;
using vl = vector<long long>;

void solve() {
  ll mod = 1000000007;
  int n, a, b;
  cin >> n >> a >> b;
  int counter = 0;
  int tmp;
  while ((a % 4 == 2 && b % 4 == 1 || a % 4 == 1 && b % 4 == 2 ||
          a % 4 == 3 && b % 4 == 0 || a % 4 == 0 && b % 4 == 3)) {

    if (a % 2 == 0) {
      a /= 2;
    } else {
      tmp = a;
      tmp--;
      tmp = tmp / 2;
      a = a - tmp;
    }
    if (b % 2 == 0) {
      b /= 2;
    } else {
      tmp = b;
      tmp--;
      tmp /= 2;
      b = b - tmp;
    }
    counter++;
    cout << a << " " << b << endl;
  }
  if (a + b == 1) {
    cout << "Toto bude epicke!" << endl;
    return;
  } else {
    cout << counter << endl;
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
