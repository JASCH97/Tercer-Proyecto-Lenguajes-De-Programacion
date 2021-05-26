:- dynamic pista/2.
:- dynamic personaje/5.
:- dynamic culpable/5.
:- use_module(library(random)).


%Al numerar o ponerles id a los personajes, se facilita el crear un culpable random.
personaje(1,emily,sombrero,collar,aretes).
personaje(2,eduardo,anillo,abrigo,pulsera).
personaje(3,carlos,reloj,camisa,cola).
personaje(4,jimena,aretes,cartera,lentes).
personaje(5,aurelio,collar,pulsera,reloj). %**


objetoRobado(corona).

%Al numerar las pistas puedo usar una relacion para obtener una random. Hace falta saber como eliminarla e igual poder obtener el nombre en Java.
pista(1,sombrero).
pista(2,gorra).
pista(3,lentes).
pista(4,abrigo).
pista(5,reloj).
pista(6,camisa).
pista(7,pulsera).
pista(8,collar).
pista(9,anillo).
pista(10,cartera).
pista(11,cola).
pista(12,aretes).



%se escoge un culpable random entre los personajes y se cambia por el culpable anterior.
culpableRandom():-
    random(1, 6, R),
    personaje(R,Nombre,Acc1,Acc2,Acc3),
    assertz(culpable(R,Nombre,Acc1,Acc2,Acc3)).

%relacion para probar que el culpable se elije random. Tambien por si accidentalmente se crea mas de un culpable, se puedan borrar.
quitarCulpable():-
    culpable(Id,Name,A1,A2,A3),
    retract(culpable(Id,Name,A1,A2,A3)),!.



%relacion que decifra si una pista conlleva al culpable o no.
decifradorPistas(Pista):-
    culpable(Id,_,_,_,_),           %se obtiene el Id del culpable
    decifradorPistasAux(Pista,Id).

decifradorPistasAux(Pista,Id):-
    personaje(Id,_,Acc1,_,_),
    Acc1 = Pista,!.

decifradorPistasAux(Pista,Id):-
    personaje(Id,_,_,Acc2,_),
    Acc2 = Pista,!.

decifradorPistasAux(Pista,Id):-
    personaje(Id,_,_,_,Acc3),
    Acc3 = Pista,!.



pistaRandom():-
    random(1,13,R), %R es un random entre 1 y 12
    pista(R,Pista),
    write(Pista),            %se imprime el nombre de la pista aleatoria
    retract(pista(R,Pista)). %se elimina luego. Si random toca en una pista eliminada, da false.


%Intento por mejorar la relacion de obtener pistaRandom para evitar que de false.
%:- dynamic ultimoIdPista/1.

%ultimoIdPista(0).  

%pistaRandom():-
%    random_between(1, 12, R),
%    ultimoIdPista(N),
%    assertz(ultimoIdPista(R)),
%    pista(R,Pista),
%    write(Pista),
%    retract(ultimoIdPista(N)),!.
%
%pistaRandom():-
%   random_between(1, 12, R),
%    ultimoIdPista(N),
%    R =:= N,
%    retract(pista(N,_)),!.
%
%pistaRandom():-
%    random_between(1, 12, R),


puntosHuellas(0).

puntosOjos(0).

puntosCulpable(0);



%sistema de puntos para los dados. Los dados van a tener huellas o ojos.
%cada cierta cantidad de huellas se revela una pista, cada cierta cantidad de ojos se pueden revelar personajes
%ambos conteos se deben mostrar en pantalla, en prolog solo se lleva la logica de los dados que van marcando

%3 ojo, 2 patas,1 dos Huellas para tener un control de las caras

%el primer argumento en dado, representa la cara del mismo. El segundo argumento, lo que muestra dicha cara
dado(1,ojo).
dado(2,huella).
dado(3,ojo).
dado(4,huella).
dado(5,ojo).
dado(6,huellas).

%relacion que imprime un lado de la cara del dado
tirarDado():-
    random_between(1, 6, R),
    dado(R,Cara),
    write(Cara),!.    


%relacion que descarta personajes. Si el personaje tiene es el culpable, imprime un mensaje de partida perdida.
descartarPersonaje(Nombre):-
    culpable(_,Name,_,_,_),
    same_term(Nombre, Name),      %same_term compara si dos terminos son iguales. =:= solo funciona con numeros. 
    write(partidaPerdida),!.

descartarPersonaje(Nombre):-
    personaje(Id,Nombre,Acc1,Acc2,Acc3),
    retract(personaje(Id,Nombre,Acc1,Acc2,Acc3)),!.





    
    
