% ---------- ROUTES (GRAPH) ----------
connected(a, b, 5).
connected(b, c, 4).
connected(c, d, 3).
connected(a, e, 2).
connected(e, d, 10).
connected(b, e, 1).

% make roads bidirectional
route(X, Y, D) :- connected(X, Y, D).
route(X, Y, D) :- connected(Y, X, D).

% ---------- BEST ROUTE ----------
best_route(Start, End, Path) :-
    path(Start, End, [Start], Path).

% path finding (DFS style)
path(End, End, Visited, Path) :-
    reverse(Visited, Path).

path(Current, End, Visited, Path) :-
    route(Current, Next, _),
    \+ member(Next, Visited),
    path(Next, End, [Next|Visited], Path).

% ---------- RECOMMEND ----------
recommend(Start, End) :-
    best_route(Start, End, Path),
    write('Best route: '), write(Path), nl.