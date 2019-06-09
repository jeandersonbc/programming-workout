#include <iostream>
using namespace std;
int main() {
    int n, entry;

    cin >> n;

    bool A = false, B = false;
    for (int i = 0; i < n; i++) {
        cin >> entry;
        if (entry == 1)
            A=!A;
        else {
            A=!A;
            B=!B;
        }
    }
    cout << A << endl << B << endl;
}
