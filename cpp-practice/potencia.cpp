#include <iostream>
#include <cmath>

using namespace std;

int main() {
    double x, y;
    cin >> x >> y;

    cout.precision(4);

    cout << fixed << pow(x, y) << endl;
}
