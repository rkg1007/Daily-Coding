class MyHashMap:
    class Node:
        def __init__(self):
            self.arr = [None for _ in range(10)]
            self.val = -1

    def __init__(self):
        self.root = self.Node()

    def put(self, key: int, value: int) -> None:
        curr = self.root
        while key > 0:
            digit = key % 10
            key = key // 10
            if curr.arr[digit] is None:
                curr.arr[digit] = self.Node()
            curr = curr.arr[digit]
        curr.val = value

    def get(self, key: int) -> int:
        curr = self.root
        while key > 0:
            digit = key % 10
            key = key // 10
            if curr.arr[digit] is None:
                return -1
            curr = curr.arr[digit]
        return curr.val

    def remove(self, key: int) -> None:
        curr = self.root
        while key > 0:
            digit = key % 10
            key = key // 10
            if curr.arr[digit] is None:
                return
            curr = curr.arr[digit]
        curr.val = -1


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)