#include <iostream>
#include <vector>
#include <numeric>

using namespace std;

int magicSquare(const vector<vector<int>> &M) {
    const int value = accumulate(M[0].begin(), M[0].end(), 0);

    int tmpSum = 0;

    for (int i = 0; i < M.size(); i++) {
        tmpSum = 0;
        for (int j = 0; j < M.size(); j++) {
            tmpSum += M[i][j];
        }
        if (tmpSum != value)
            return -1;
    }
    for (int j = 0; j < M.size(); j++) {
        tmpSum = 0;
        for (int i = 0; i < M.size(); i++) {
            tmpSum += M[i][j];
        }
        if (tmpSum != value)
            return -1;
    }
    tmpSum = 0;
    for (int i = 0; i < M.size(); i++) {
        tmpSum += M[i][i];
    }
    if (tmpSum != value)
        return -1;

    tmpSum = 0;
    for (int i = 0; i < M.size(); i++) {
        tmpSum += M[i][M.size() - 1 - i];
    }
    if (tmpSum != value)
        return -1;

    return value;
}
int main() {
    int N;
    cin >> N;

    vector<vector<int>> M;

    for (int i=0; i<N; i++) {
        vector<int> row;
        M.push_back(row);
        for (int j=0; j<N; j++) {
            int tmp;
            cin >> tmp;
            M[i].push_back(tmp);
        }
    }
    cout << magicSquare(M) << endl;
}
