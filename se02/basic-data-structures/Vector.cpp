#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
    vector<int> V; // creation
    cout << V.size() << endl;
    cout << V.capacity() << endl;

    // adding elements...
    for (int i = 3; i >= 0; i--)
        V.push_back(i);

    vector<int>::iterator it = V.begin();
    while(it != V.end()) {
        cout << (*it++) << " ";
    }
    cout << endl << "Size: " << V.size() << endl;

    // access last element
    int x = V.back();
    cout << "Removed:" << x << endl;

    // returns void
    V.pop_back();
    cout << "Size: " << V.size() << endl;

    it = V.begin();
    while(it != V.end()) {
        cout << (*it++) << " ";
    }
    cout << endl;
    sort(V.begin(), V.end());

    it = V.begin();
    while(it != V.end()) {
        cout << (*it++) << " ";
    }
}
