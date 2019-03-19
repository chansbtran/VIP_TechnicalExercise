# VIP_TechnicalExercise
Write a program that allows for an integer array to be passed in and will then output all of the pairs that sum up to 10.
Please provide a solution that allows for
  1) output all pairs (includes duplicates and the reversed ordered pairs)
  2) output unique pairs only once (removes the duplicates but includes the reversed ordered pairs)
  3) output the same combo pair only once (removes the reversed ordered pairs)

  For example passing in [1, 1, 2, 4, 4, 5, 5, 5, 6, 7, 9] the following results should occur:
    1) output all pairs would output: [1,9], [1,9], [4,6], [4,6], [5,5], [5,5], [5,5], [5,5], [5,5], [5,5], [6,4], [6,4] [9,1] , [9,1] 
    2) output unique pairs only once would output: [1,9], [4,6], [5,5], [6,4], [9,1] 
    3) output the same combo pair only once would output: [1,9], [4,6], [5,5]   
