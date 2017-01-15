$(document).ready(function () {
    var chessboard = ChessBoard('chessboard', {
        draggable:true,
        position: 'start'
    });
    
    $("#fenForm").submit(function() {
        $("#FEN").value(chessboard.fen());
    });
});
