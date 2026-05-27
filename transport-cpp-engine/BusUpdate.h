#ifndef BUS_UPDATE_H
#define BUS_UPDATE_H

#include <string>
using namespace std;

struct BusUpdate {
    string busId;
    double latitude;
    double longitude;
    int speed;
};

#endif