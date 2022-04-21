class Solution:
    def dfs(self, graph, currCourse, isCompleted, isVisited):
        isVisited[currCourse] = True
        for prerequisite in graph[currCourse]:
            if isCompleted[prerequisite] == -1:
                isCompleted[currCourse] = -1
                return -1
            elif isCompleted[prerequisite] == 0:
                if isVisited[prerequisite] is True:
                    isCompleted[currCourse] = -1
                    return -1
                else:
                    completed = self.dfs(graph, prerequisite, isCompleted, isVisited)
                    if completed == -1:
                        isCompleted[currCourse] = -1
                        return -1
        isCompleted[currCourse] = 1
        return 1
    
        
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        graph = {}
        for course in range(numCourses):
            graph[course] = {}
        for u, v in prerequisites:
            graph[u][v] = 1
        
        isCompleted = [0 for _ in range(numCourses)]
        isVisited = [False for _ in range(numCourses)]
        
        for course in range(numCourses):
            if isCompleted[course] == 0:
                self.dfs(graph, course, isCompleted, isVisited)
        
        for completed in isCompleted:
            if completed == -1:
                return False
        
        return True
        