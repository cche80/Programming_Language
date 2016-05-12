; -- these are the same thing
;(print (eval (list 'setq (cadar '((? u) 3)) (list 'quote (car '(b 6))))))
;(print (eval (list 'setq (cadar '((? u) 3)) (car '('b 6)))))


( setq pattern (list (list '? 'a) 'b 'c) )
( setq assertion (list 'o 'q 'r) )

;(setq a (append a '(cons 'b nil)))
;(print a)

;(setq a '())
;(eval (list 'setq (cadar pattern) ''() ) )

(print (boundp (cadar pattern)))

(eval (list 'setq (cadar pattern) '(  )))
(eval (list 'setq (cadar pattern) (list 'append  (cadar pattern) (list 'cons (list 'quote (car assertion)) 'nil))))

(print (boundp (cadar pattern)))
(print (listp (eval (cadar pattern))))

;(eval (list 'setq (cadar pattern) (list  )))
(print a)





; --- backup
    ; (cond 
    ;          (
    ;           ; -- test condition  
    ;           (atom (cadar pattern))
    ;           ; -- if so do the following statements
    ;              (eval (list 'setq (cadar pattern) (list 'append  (cadar pattern) (list 'cons (list 'quote (car assertion)) 'nil))))
    ;         )
    ;         (t     ; -- else
    ;             (eval (list 'setq (cadar pattern) '() ) )
    ;             (eval (list 'setq (cadar pattern) (list 'append  (cadar pattern) (list 'cons (list 'quote (car assertion)) 'nil))))
    ;     
    ;         )
    ;     )