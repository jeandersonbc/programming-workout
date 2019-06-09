#include <iostream>
#include <cmath>
using namespace std;

int main() {
    int n;
    cin >> n;

    cout.precision(4);

    double value = 0.0;
    for (int i = 0; i < n; i++) {
        cin >> value;
        cout << fixed << sqrt(value) << endl;
    }
}

