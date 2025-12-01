class Solution(object):
    def maxRunTime(self, n, batteries):
        """
        :type n: int
        :type batteries: List[int]
        :rtype: int
        """

        left = 0
        right = sum(batteries) // n

        def canRun(T):
            total = 0
            for b in batteries:
                total += min(b, T)
            
            return total >= T * n


        while( left < right ):
            mid = (right + left + 1) //2
            if canRun(mid):
                left = mid
            else:
                right = mid - 1
        return left
