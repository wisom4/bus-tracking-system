% Route status facts

congested(route1).

fast(route2).
fast(route3).
% Avoid congested routes

avoid(Route) :-
    congested(Route).

% Recommend fast routes that are not congested

recommend(Route) :-
    fast(Route),
    \+ congested(Route).
    % Best route logic

best_route(Route) :-
    fast(Route),
    \+ congested(Route).

% Fallback logic

fallback_route(Route) :-
    congested(Route),
    \+ fast(Route).