bool canVisitAllRooms(int** rooms, int roomsSize, int* roomsColSize) {
    
    bool opened[roomsSize];
    int keys[roomsSize];
    for (int i = 0; i < roomsSize; i++) {
        opened[i] = false;
        keys[i] = 0;
    }

    opened[0] = true;
    int size = 1;
    for (int i = 0; i < size; i++) {
        int roomKeys = roomsColSize[keys[i]];
        for (int j = 0; j < roomKeys; j++) {
            int key = rooms[keys[i]][j];
            if (opened[key]) continue;
            opened[key] = true;
            keys[size++] = key;
        }
    }

    bool result = true;
    for (int i = 0; i < roomsSize; i++) {
        if (!opened[i]) {
            result = false;
            break;
        }
    }
    return result;
}