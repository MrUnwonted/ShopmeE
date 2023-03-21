const Toast = Swal.mixin({
    toast: true,
    position: 'top-right',
    iconColor: 'white',
    customClass: {
        popup: 'colored-toast'
    },
    showConfirmButton: false,
    timer: 5000,
    timerProgressBar: true
})

function success(message){
    Toast.fire({
        icon: 'success',
        title: 'Success',
        text: message,
        background: 'green'

    })
}
function error(message){
    Toast.fire({
        icon: 'error',
        title: message,
        background: 'red'

    })
}

function warning(message){
    Toast.fire({
        icon: 'warning',
        title: message,
        background: 'yellow'
    })
}
function info(message){
     Toast.fire({
        icon: 'info',
        title: message,
         background: 'blue'

     })
}
function question(message){
    Toast.fire({
        icon: 'question',
        title: message,
        background: 'lightblue'
    })

}
