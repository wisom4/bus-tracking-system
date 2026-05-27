#ifndef BUS_ENGINE_H
#define BUS_ENGINE_H

#include <vector>
#include <thread>
#include "SafeQueue.h"

class BusEngine {
private:
    SafeQueue& queue;
    vector<thread> workers;
    bool running;

public:
    BusEngine(SafeQueue& q, int numThreads);

    void process();
    void stop();
};

#endif