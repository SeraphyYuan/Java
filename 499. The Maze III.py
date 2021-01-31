class Solution:
    def findShortestWay(self, maze: List[List[int]], ball: List[int], hole: List[int]) -> str:
        m = len(maze)
        n = len(maze[0])
        heap = [(0, "", ball[0], ball[1])]
        dirs = [(1,0,"d"),(-1,0,"u"), (0,1,"r"), (0,-1, "l")]
        distances = collections.defaultdict(list)
        distances[(ball[0], ball[1])] = [0, ""]
        
        while heap : 
            distance, pattern, i, j = heapq.heappop(heap)
            if[i,j] == hole :
                return pattern
            for dx, dy, dir in dirs:
                step, x, y = distance, i, j
                while(0<=x+dx<m and 0<= y + dy<n and maze[x+dx][y+dy] == 0):
                    x += dx
                    y += dy
                    step += 1
                    if [x, y] == hole :
                        break;
                if (x, y) not in distances or [step, pattern + dir] < distances[(x, y)]:
                    distances[(x, y)] = [step, pattern + dir]
                    heapq.heappush(heap, [step, pattern + dir, x, y])
        return "impossible"
