#include <stdlib.h>
// Structure for hash map entries
typedef struct {
    int key;
    int value; // Stores original array index
    int occupied; // 0: empty, 1: occupied
} HashNode;
// Function to calculate hash index
int hash(int key, int size) {
    return abs(key) % size;}
// Search for key using linear probing
int search(HashNode *table, int size, int key) {
    int idx = hash(key, size);
    while (table[idx].occupied) {
        if (table[idx].key == key) return table[idx].value;
        idx = (idx + 1) % size;
    }
    return -1;}
// Insert key-value pair using linear probing
void insert(HashNode *table, int size, int key, int value) {
    int idx = hash(key, size);
    while (table[idx].occupied) {
        idx = (idx + 1) % size;    }
    table[idx].key = key;
    table[idx].value = value;
    table[idx].occupied = 1;
}

// Two Sum solution using hash table
int* twoSum(int* nums, int numsSize, int target, int* returnSize) {
    int hashSize = numsSize * 2; // Size to reduce collisions
    HashNode *hashTable = (HashNode*)calloc(hashSize, sizeof(HashNode));
    int *result = (int*)malloc(2 * sizeof(int));
    *returnSize = 2;

    for (int i = 0; i < numsSize; i++) {
        int complement = target - nums[i];
        int foundIdx = search(hashTable, hashSize, complement);
        
        if (foundIdx != -1) {
            result[0] = foundIdx;
            result[1] = i;
            free(hashTable);
            return result;
        }
        insert(hashTable, hashSize, nums[i], i);
    }
    free(hashTable);
    return NULL; 
}