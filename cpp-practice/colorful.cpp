#include <iostream>
#include <algorithm>

using namespace std;

const int MAX = 9;

int main() {
    int N;
    cin >> N;

    int colors[N];
    int line[N];

    for (int i=0; i<N; i++)
        cin >> line[i];

    for (int i = 0; i < N; i++) {
        if (line[i] == 0) {
            colors[i] = 0;
            continue;
        }

        int count = 0;
        bool found = false;
        for (int k = i - 1; k >= 0 && !found; k--) {
            count++;
            if (line[k] == 0)
                found = true;
        }
        int left = found && count < MAX ? count : MAX;

        count = 0;
        found = false;
        for (int k = i + 1; k < N && !found; k++) {
            count++;
            if (line[k] == 0)
                found = true;
        }
        int right = found && count < MAX ? count : MAX;

        colors[i] = min(left, right);
    }
    for (int i=0; i<N-1; i++)
        cout << colors[i] << " ";
    cout << colors[N-1] << endl;
}
