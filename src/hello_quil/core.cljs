(ns mondrian-quil.core
  (:require [quil.core :as q :include-macros true]
            [quil.middleware :as m]))


(defn draw [state]
  ; always white background .
  (q/background 255)

  ; no stroke for squares
  (q/no-stroke)

  ; red square.
  (q/fill 255 0 0)
  (q/rect 50 50 100 100)

  ; blue square.
  (q/fill 0 0 255)
  (q/rect 150 200 200 100)

  ; yellow square.
  (q/fill 255 255 0)
  (q/rect 150 150 75 50)

  ; black rectangle.
  (q/fill 0 0 0)
  (q/rect 150 50 75 50)

  ; let's do some black lines
  (q/stroke 0 0 0)
  (q/stroke-weight 5)

  (q/line 50 0 50 300)
  (q/line 150 50 150 300)
  (q/line 225 0 225 200)
  (q/line 100 150 100 200)

  (q/line 0 50 345 50)
  (q/line 150 50 220 50)
  (q/line 0 150 345 150)
  (q/line 0 200 345 200)
  (q/line 0 250 150 250))

(q/defsketch mondrian-quil
  :host "mondrian-quil"
  :size [500 300]
  ; setup function called only once, during sketch initialization.
  ;:setup setup
  ; update is called on each iteration before draw is called.
  ; It updates sketch state.
  ;:update update
  :draw draw
  ; This sketch uses functional-mode middleware.
  ; Check quil wiki for more info about middlewares and particularly
  ; fun-mode.
  ;:middleware [m/fun-mode]
  )
