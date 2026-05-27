#include <iostream>
#include "SafeQueue.h"
#include "BusEngine.h"

using namespace std;

int main() {
    SafeQueue queue;

    BusEngine engine(queue, 4);

    for (int i = 0; i < 10; i++) {
        BusUpdate b {
            "BUS-" + to_string(i),
            13.45 + i * 0.001,
            -16.57 + i * 0.001,
            30 + i
        };

        queue.push(b);
    }

    this_thread::sleep_for(chrono::seconds(3));
    engine.stop();

    return 0;
}