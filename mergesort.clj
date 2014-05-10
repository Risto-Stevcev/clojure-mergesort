(use 'clojure.java.io)

(defn merge' [left right]
  (if (empty? right) left
      (if (empty? left) right
          (if (<= (first left) (first right)) 
              (cons (first left)  (merge' (rest left) right))
              (cons (first right) (merge' left (rest right)))
                  ))))

(defn merge_sort [list]
  (if (or (empty? list) (nil? (next list))) list
      (let [mid (quot (count list) 2)]
           (merge' (merge_sort (take mid list)) 
           (merge_sort (drop mid list)))
               )))

(defn parse-int [s]
   (Integer. (re-find  #"\d+" s )))

(defn get-lines [fname]
  (with-open [r (reader fname)]
    (doall (map parse-int (line-seq r)))))

(let [list (get-lines "IntArray.txt")]
 (print (merge_sort list)))


;(print "merge '(1 2 6) '(3 4 7):     ")
;(println (merge' '(1 2 6) '(3 4 7)))
;(print "merge sort '(7 2 3 1 4 6 5): ")
;(println (merge_sort '(7 2 3 1 4 6 5)))
