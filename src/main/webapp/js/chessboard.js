$(document).ready(function () {
    var chessboard = ChessBoard('chessboard', {
        draggable:true,
        position: 'start'
    });
    
    $("#fenForm").submit(function() {
        var fen = chessboard.fen();
        $("#fen").val(fen);
    });
});
