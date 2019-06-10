#include <iostream>
#include <sstream>
using namespace std;

const int MAX = 100010;

int values[MAX];

short interval[MAX << 2];
inline int left(int v) { return (v*2 + 1); }
inline int right(int v) { return (v*2 + 2); }

char translate(short value) {
    if (value > 0) return '+';
    if (value < 0) return '-';
    return '0';
}

void build(int i, int j, int pos) {
    if (i == j) {
        short signal = 0;
        if (values[i] > 0) signal = 1;
        if (values[i] < 0) signal = -1;

        interval[pos] = signal;
        return;
    }
    int mid = (i + j) >> 1;
    build(i, mid, left(pos));
    build(mid+1, j, right(pos));
    interval[pos] = (interval[left(pos)] * interval[right(pos)]);
}

// AUXILIARY
void print(int i, int j, int pos) {
    cout << i << " " << j << " " << interval[pos] << endl;
    if (i == j) return;
    int mid = (i + j) >> 1;
    print(i, mid, left(pos));
    print(mid+1, j, right(pos));
}

int main() {

    int N, K;

    while (cin >> N >> K) {
        cout << "Test case" << endl;

        for (int i = 0; i < N; i++)
            cin >> values[i];

        build(0, N-1, 0);
        print(0, N-1, 0);

        char op;
        int x, y;
        for (int i = 0; i < K; i++) {
            cin >> op >> x >> y;
            // TODO
        }
    }
}
