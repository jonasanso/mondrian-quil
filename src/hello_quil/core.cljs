(ns mondrian-quil.core
  (:require [quil.core :as q :include-macros true]
            [quil.middleware :as m]))

(def squares
  [ {:color [255 0 0]
     :rect [50 50 100 100]}
    {:color [0 0 255]
     :rect [150 200 200 100]}
    {:color [255 255 0]
     :rect [150 150 75 50]}
    {:color [0 0 0]
     :rect [150 50 75 50]} ])

(def lines
  [ [50 0 50 300]
    [150 50 150 300]
    [225 0 225 200]
    [100 150 100 200]
    [0 50 345 50]
    [150 50 220 50]
    [0 150 345 150]
    [0 200 345 200]
    [0 250 150 250] ])

(defn draw []
  ; always white background .
  (q/background 255)

  ; no stroke for squares
  (q/no-stroke)
  (doseq [s squares]
    (apply q/fill (:color s))
    (apply q/rect (:rect s)))

  ; let's do some black lines
  (q/stroke 0 0 0)
  (q/stroke-weight 5)
  (doseq [line lines]
    (apply q/line line)))

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
