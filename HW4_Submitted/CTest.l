; -- these are the same thing
;(print (eval (list 'setq (cadar '((? u) 3)) (list 'quote (car '(b 6))))))
;(print (eval (list 'setq (cadar '((? u) 3)) (car '('b 6)))))( setq pattern (list (list '? 'a) 'b 'c) )

;(eval (list 'setq (cadar pattern) (list 'quote (car assertion))))

;( setq pattern (list (list '? 'a) 'b 'c) )
;( setq assertion (list 'o 'q 'r 'c) )

;(setq a (butlast pattern)) (print a)


;(eval (list 'setq (cadar pattern) '(  )))
;(eval (list 'setq (cadar pattern) (list 'append  (cadar pattern) (list 'cons (list 'quote (car assertion)) 'nil))))
;(eval (list 'setq (cadar pattern) (list 'append  (cadar pattern) (list 'cons (list 'quote (cadr assertion)) 'nil))))
;(eval (list 'setq (cadar pattern) (list 'append  (cadar pattern) (list 'cons (list 'quote (caddr assertion)) 'nil))))
;(eval (list 'setq (cadar pattern) (list 'append  (cadar pattern) (list 'cons (list 'quote (cadddr assertion)) 'nil))))



;(eval (list 'setq (cadar pattern) (list 'quote (butlast pattern)) ) )
;(print a)

;(eval (list 'setq (cadar pattern) (list 'quote (butlast (eval (cadar pattern) ))) ) )

;(print (list 'quote (butlast pattern)))

;(print (list pattern 'quote (butlast pattern)))

;(print (list 'quote pattern (butlast pattern)))

;(print (list 'quote))
;(print a)







(setq pattern '((4 'a) 2 3))

(print (listp a))

(print (eval (list 'listp (list 'quote (cadar pattern)))))



