Clojure Merge Sort
==================

This was an exercise to get more acquainted with the Clojure dialect of Lisp. The mergesort implementation
wasn't particularly fast, which is what I expected:

    $ time clojure -j -Xss6m mergesort.clj 
    real	0m3.113s
    user	0m3.303s
    sys     0m0.083s
