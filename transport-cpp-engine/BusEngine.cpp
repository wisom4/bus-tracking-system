#include "BusEngine.h"
#include <iostream>
#include <chrono>

using namespace std;

BusEngine::BusEngine(SafeQueue& q, int numThreads)
    : queue(q), running(true) {

    for (int i = 0; i < numThreads; i++) {
        workers.emplace_back(&BusEngine::process, this);
    }
}

void BusEngine::process() {
    while (running) {
        BusUpdate update = queue.pop();

        cout << "Processing Bus: " << update.busId << endl;

        this_thread::sleep_for(chrono::milliseconds(200));
    }
}

void BusEngine::stop() {
    running = false;

    for (auto& t : workers) {
        if (t.joinable()) t.join();
    }
}