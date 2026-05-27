#ifndef SAFE_QUEUE_H
#define SAFE_QUEUE_H

#include <queue>
#include <mutex>
#include <condition_variable>
#include "BusUpdate.h"

class SafeQueue {
private:
    queue<BusUpdate> q;
    mutex mtx;
    condition_variable cv;

public:
    void push(BusUpdate update);

    BusUpdate pop();
};

#endif