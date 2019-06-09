#include <vector>
#include <iostream>
using namespace std;

int main() {
    int N;
    cin >> N;

    int board[N][N];
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> board[i][j];
        }
    }

    int rowCost[N];
    int colCost[N];
    for (int j = 0; j < N; j++) {
        colCost[j] = 0;
        for (int i = 0; i < N; i++) {
            colCost[j] += board[i][j];
        }
    }
    for (int i = 0; i < N; i++) {
        rowCost[i] = 0;
        for (int j = 0; j < N; j++) {
            rowCost[i] += board[i][j];
        }
    }

    int maxCost = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            int cost = rowCost[i] + colCost[j] - (2 * board[i][j]);
            if (cost > maxCost)
                maxCost = cost;
        }
    }
    cout << maxCost << endl;
}
