const stripe = Stripe('pk_test_51PSqfXCpRO9yD5E5jvROk7bCuvI9FnIDmMUgPASXg6hmbRo0bnLCuTpI6yd88r0ScnNDOsKtUHQcck2HiMBbfswo00Qm5MuAAb');
const paymentButton = document.querySelector('#paymentButton');

paymentButton.addEventListener('click', () => {
	stripe.redirectToCheckout ({
		sessionId: sessionId
	})
});