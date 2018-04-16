(ns four-clojure.core-test
  (:require [clojure.test :refer :all]
            [four-clojure.core :refer :all]))

(deftest my-last-test
  (is (= (my-last [1 2 3 4 5]) 5))
  (is (= (my-last '(5 4 3)) 3))
  (is (= (my-last ["b" "c" "d"]) "d")))

(deftest my-penultimate-test
  (is (= (my-penultimate (list 1 2 3 4 5)) 4))
  (is (= (my-penultimate ["a" "b" "c"]) "b"))
  (is (= (my-penultimate [[1 2] [3 4]]) [1 2])))

(deftest my-nth-element-test
  (is (= (my-nth-element '(4 5 6 7) 2) 6))
  (is (= (my-nth-element [:a :b :c] 0) :a))
  (is (= (my-nth-element [1 2 3 4] 1) 2))
  (is (= (my-nth-element '([1 2] [3 4] [5 6]) 2) [5 6])))

(deftest my-count-test
  (is (= (my-count '(1 2 3 3 1)) 5))
  (is (= (my-count "Hello World") 11))
  (is (= (my-count [[1 2] [3 4] [5 6]]) 3)))

(deftest my-reverse-test
  (is (= (my-reverse [1 2 3 4 5]) [5 4 3 2 1]))
  (is (= (my-reverse (sorted-set 5 7 2 7)) '(7 5 2)))
  (is (= (my-reverse [[1 2] [3 4] [5 6]]) [[5 6] [3 4] [1 2]])))

(deftest only-odd-test
  (is (= (only-odds [4 2 1 6]) '(1))))

(deftest palidrome?-test
  (is (false? (palindrome? '(1 2 3 4 5))))
  (is (true? (palindrome? [:foo :bar :foo])))
  (is (true? (palindrome? '(1 1 3 3 1 1))))
  (is (false? (palindrome? '(:a :b :c))))
  (is (true?  (palindrome? "racecar"))))

(deftest my-flatten-test
  (is (= (my-flatten '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6)))
  (is (= (my-flatten ["a" ["b"] "c"]) '("a" "b" "c")))
  (is (= (my-flatten '((((:a))))) '(:a))))

(deftest only-upper-case-test
  (is (= (only-upper-case "HeLlO, WoRlD!") "HLOWRD"))
  (is (empty? (only-upper-case "nothing")))
  (is (= (only-upper-case "$#A(*&987Zf") "AZ")))

(deftest compress-seq-test
  (is (= (apply str (compress-seq "Leeeeeerrroyyy")) "Leroy"))
  (is (= (compress-seq [1 1 2 3 3 2 2 3]) '(1 2 3 2 3)))
  (is (= (compress-seq [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))))

(deftest pack-seq-test
  (is (= (pack-seq [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3))))
  (is (= (pack-seq [:a :a :b :b :c]) '((:a :a) (:b :b) (:c))))
  (is (= (pack-seq [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))))

(deftest duplicates-elements-test
  (is (= (duplicates-elements [1 2 3]) '(1 1 2 2 3 3)))
  (is (= (duplicates-elements [:a :a :b :b]) '(:a :a :a :a :b :b :b :b)))
  (is (= (duplicates-elements [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))))
