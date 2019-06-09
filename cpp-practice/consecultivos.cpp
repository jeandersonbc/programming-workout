#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;

    int values[n];
    for (int i = 0; i < n; i++) {
        cin >> values[i];
    }

    int currentValue = values[0];
    int currentLenght = 1;

    int score = currentLenght;
    for (int i = 1; i < n; i++) {
        if (values[i] == currentValue) {
            currentLenght++;
        } else {
            currentLenght = 1;
            currentValue = values[i];
        }
        if (currentLenght > score)
            score = currentLenght;

    }
    cout << score << endl;
}
