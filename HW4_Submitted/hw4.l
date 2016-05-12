;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Your solution goes in this file ;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; PART 1 ;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defun all-length(x)
    (if (null x) 
        0 ; just put a terminal here, the function will return that.
        ; --else
        (if (listp (car x))
            (+ (all-length (car x)) (all-length (cdr x)))
            (+ 1 (all-length (cdr x)))
        )
    )
)
; for lisp terminal, you can either return a list or a atom.
; Things in () are always evaluated.
     
     

 ; ---  part 1 question 2     
 (defun range(x) 
    (list (minx x) (maxx x))
 )


(defun minx(listx)

   (if (null (cdr listx)) (car listx)
   
       (if (<= (car listx) (minx (cdr listx))) ;recursive
           (car listx)
           (minx (cdr listx))
        )
    )
) 

(defun maxx(listx)

   (if (null (cdr listx)) 
       ; -- then
       (car listx)
       ; -- else       
       (if (>= (car listx) (maxx (cdr listx)))
           (car listx)
           (maxx (cdr listx))
        )
    )
) 


; -- part 1 question 3       

(defun before (start stop listx)
    (if (null listx)
       ; -- then
       (list) ; return an empty list
       ;-- else
       (if (equal start (car listx))
            ; -- then
            (before_help stop (cdr listx) (list (car listx)))
            ; -- else
            (before start stop (cdr listx)) ;recurse the rest of the list
        )
    )
)

(defun before_help(stop listx newList); this will be called when the appending
                                      ; starts, starting from the atom: start.
    
    (if (null listx)
       ; -- then
       newList
       ;-- else
       (if (equal stop (car listx))
            ; -- then
            (append newList (cons (car listx) nil))
            ; -- else
            (before_help stop (cdr listx) (append newList (cons (car listx) nil)))
       )
    )
)

; --- part 1, question 4

(defun split-if(fxn listx)

    (if (null listx)
        ;--then
        (list 'nil 'nil)
        ;--else
        (split-if-help (mapcar fxn listx) (list) (list) listx)
    )
)


(defun split-if-help(testedList listT listF listx )
    (if (null testedList)
        ;--then 
        (list listF listT)
        ;-- else
        (if (eql T (car testedList))  ; check if first element is had passed the function test
           ; -- then
           
           ; call split if helper again with top element of 
           (split-if-help (cdr testedList) (append listT (cons (car listx) nil)) listF (cdr listx))
           
           ;-- else
           
           ; call split if helper again with top element of 
           (split-if-help (cdr testedList) listT (append listF (cons (car listx) nil)) (cdr listx))
        )   
    )
)    



;  -- part 1, question 5


(defun group(listx subgroupSize)

  (group-helper (list) (list) subgroupSize subgroupSize listx)

)




(defun group-helper(subgroupedList currentSubgroupTuple remainInTuple subgroupSize listx)

    (if (null listx) ; if there are no more elements in listx
        ; -- then
        
        ; add the current working tuple to the list and return the list
        (if (eql remainInTuple subgroupSize) ; check if working tuple is empty
            subgroupedList   ; if so don't add anything
            (append subgroupedList (list currentSubgroupTuple)) ; add it if its non empty
        )
        ; -- else
        
        ;test if current entry will be the last entry in this tuple
        (if (zerop (- remainInTuple 1))
        
            ; --then call the function with appropriate parameters
            (group-helper 
                (append subgroupedList (list (append currentSubgroupTuple (cons (car listx) nil))))
                (list)   ;currentSubgroupTuple will be reset for next time
                subgroupSize   ; reset the remaininginTuple
                subgroupSize
                (cdr listx)
            )
            
            ;--- else
            
            ;call the function with  mainly currentSubgroupTuple updated
            (group-helper
                  subgroupedList
                  (append currentSubgroupTuple (cons (car listx) nil))  ; add element to working tuple
                  (- remainInTuple 1)   ; subtract one from remaining
                  subgroupSize
                  (cdr listx)
            )
       )
    )   
)


; --- part1, question 6 ----

(defun mostn(function listx)
  
  (if (null listx)
     ; -- if list empty return empty list
     (list) ; return an empty list
     ; -- oterwise evaluate maxvalue for all elements of the list, find maximum of that, and call helper function
     (mostn-helper 
         (maxx (mapcar function listx))
         (mapcar function listx)
         (list)
         listx
      )
  )
)  

(defun mostn-helper(maxValue maxValueList finalizingList listx)
  
  (if (null listx)
      ; -- then return working list
      (list finalizingList maxValue)
      ;else
      (if (eql maxValue (car maxValueList))
          ;-- then
          (mostn-helper maxValue (cdr maxValueList) (append finalizingList (list (car listx))) (cdr listx))
          ;-- else
          (mostn-helper maxValue (cdr maxValueList) finalizingList (cdr listx))
      )    
  )
)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; PART 2 ;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defun match (pattern assertion)
    (cond
        (
        ( or (null assertion)
             (null pattern) )
                (equal assertion pattern)
        )
        
        (
        ( eql (car pattern) '? )
            ( match (cdr pattern) (cdr assertion) )
        )
        
        (
        ( and ( eql (car pattern) '! )
              ( match (cdr pattern) (cdr assertion) ) )
            t
        )
        
        (
        ( eql (car pattern) '! )
            ( match pattern (cdr assertion) )
        )
        
        ( t
            ( and ( eql (car pattern) (car assertion) )
                  ( match (cdr pattern) (cdr assertion) ) )
        )
    )
)


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;; -- part 3 --;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defun match-var(pattern assertion)
   (setq backuplist (list 't1 't2 't3 't4 't5 't6 't7 't8 't9 't10 't11 't12 't13 't14 't15 't16 't17 't18 't19 't20))
   (backup-var pattern backuplist)
    (clear-var pattern)
    (cond 
        ((match-var-help pattern assertion)
          t
        )
        (t 
         (restore-var pattern backuplist)
         nil
        )
    )
)



(defun match-var-help (pattern assertion)
    (cond
        (       ; cond 1: null
        ( or (null assertion) (null pattern) )
            (equal assertion pattern)
        )
        
        (       ; cond 2: if pattern head is list and the caar is a ?
        (and ( listp (car pattern) ) (eql (caar pattern) '?) )
            ; --then
               
            ; if body
            ; get the second atom from head list...
            ; and bind assertion's head to it
            ; E.g. pattern is ( (? a) u), assertion is (b c)...
            ; We bind b to a
            ; (setq (cadar pattern) (car assertion))
            (eval 
                (list 'setq (cadar pattern) (list 'quote (car assertion))
                )
            )
            
            (match-var-help (cdr pattern) (cdr assertion))
            
        )
        
        
        (       ; cond 3: if pattern head is list and the caar is a !
                ; and recursively calling match-var.
        (and ( listp (car pattern) ) (eql (caar pattern) '!)) 
            ; -- body of 
            
          ; (eval (list 'setq (cadar pattern) '() ) )
          ; (eval (list 'setq (cadar pattern) (list 'append  (cadar pattern) (list 'cons (list 'quote (car assertion)) 'nil))))
          
          (cond 
              (
               ; -- test condition  
               (boundp (cadar pattern))
               ; -- if so do the following statements
                  (eval (list 'setq (cadar pattern) (list 'append  (cadar pattern) (list 'cons (list 'quote (car assertion)) 'nil))))
              )
             (t     ; -- else
                   (eval (list 'setq (cadar pattern) '() ) )
                   (eval (list 'setq (cadar pattern) (list 'append  (cadar pattern) (list 'cons (list 'quote (car assertion)) 'nil))))
           
               )
              
          )   
            
              (cond
                  ( ; first condition
                  ( match-var-help (cdr pattern) (cdr assertion) ) 
                  ; -- then return true
                  t
                  )
                  
                  ;-- else revert the bindings and return match (l1, l2's rest)
                  ( t
                     ; (eval
                     ;(list 'setq
                      ;      (cadar pattern)
                      ;      (list 'quote ( butlast ( eval ( cadar pattern) ) ) )
                      ;)
                      ;)
                      
                      ( match-var-help pattern (cdr assertion) )
                  )
              )
        )
            
       
        ( t     ; cond else
            ( and ( eql (car pattern) (car assertion) )
                ; FIX: might have to use equal
                  ( match-var-help (cdr pattern) (cdr assertion) ) 
            )
        )
    )
)

;clear-var unbounds the previously bounded variables
(defun clear-var (pattern)

    (cond ( (null pattern))
        (
          (and (listp (car pattern)) (boundp (cadar pattern)))
            (if (not (null (cadar pattern)))
            (makunbound (cadar pattern))
            ) 
            (clear-var(cdr pattern)))
        (t
          (clear-var(cdr pattern))
        )
    )    
    
)


(defun backup-var( pattern backup)
      (cond 
        ( 
          ;-- if one of the string is empty thats it, stop recursion
          
          (or (null (car pattern)) (null (car backup))) 
        )
        (
          (and (and (listp (car pattern)) (boundp (cadar pattern))) (not (null (cadar pattern))))
               ;(print 'In1AND)
               (eval (list 'setq (car backup) (cadar pattern)))
               (backup-var (cdr pattern) (cdr backup))
        )
        (t 
             (backup-var  (cdr pattern)  backup)
        )

      )
)

; -- this function will restore the original values of the variables
(defun restore-var (pattern backup)
    (cond 
        ( 
          ;-- if one of the string is empty thats it, stop recursion
          (or (null (car pattern)) (null (car backup)))        ;  (print 'In2ndNill)
 
        )
        (
          (and (and (listp (car pattern)) (boundp (cadar pattern))) (not (null (cadar pattern))))
               ;(print 'In2AND)
               (eval (list 'setq (cadar pattern) (car backup)))
               (restore-var (cdr pattern) (cdr backup))
        )
        (t 
            ;(print 'In2ELSE)
             (restore-var  (cdr pattern)  backup)
        )

      )
)

;(print (MATCH-VAR '((! U) A (? V)) '(B C A D)))
;(print (eval 'u))
;(print (MATCH-VAR '((! U) (? V) C (! W)) '(B C A D)))
;(print (eval 'u))
;(print (MATCH-VAR '(A (! U) A (? V) A (! W)) '(A A A A B A A)))
;(print (eval 'u))

