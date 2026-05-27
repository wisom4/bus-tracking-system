#include "SafeQueue.h"

void SafeQueue::push(BusUpdate update) {
    unique_lock<mutex> lock(mtx);
    q.push(update);
    cv.notify_one();
}

BusUpdate SafeQueue::pop() {
    unique_lock<mutex> lock(mtx);

    cv.wait(lock, [&]() {
        return !q.empty();
    });

    BusUpdate val = q.front();
    q.pop();
    return val;
}