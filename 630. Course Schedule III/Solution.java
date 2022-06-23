class Solution {
	public int scheduleCourse(int[][] courses) {
		Arrays.sort(courses, (a, b) -> a[1] - b[1]);
		//Sort the courses by their deadlines (Greedy! We have to deal with courses with early deadlines first)
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int totalTime = 0, count = 0;

		for (int[] course : courses) {
			int time = course[0], end = course[1];
			pq.offer(time); // add current course time to a priority queue
			totalTime += time;
			count++;
			while (totalTime > end) {
				totalTime -= pq.poll(); // If totalTime exceeds, drop the previous course
				count--; // which costs the most totalTime. (That must be the best choice!)
			}
		}
		return count;
	}
}