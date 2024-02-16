class Budget {
    constructor(name, amount) {
        this.name = name;
        this.amount = amount;
    }
}

class BudgetUI {
    static displayBudget() {
        const budgetList = document.getElementById('budgetSummary');
        const totalAmountElement = document.getElementById('totalAmountValue');
        let totalAmount = 0;

        budgetList.innerHTML = '';

        BudgetUI.budget.forEach((budget) => {
            const li = document.createElement('li');
            li.className = 'list-group-item';
            li.innerHTML = `<strong>${budget.name}</strong>: ₹${budget.amount}`;
            budgetList.appendChild(li);

            totalAmount += budget.amount;
        });

        totalAmountElement.textContent = totalAmount.toFixed(2);
    }
}


class BudgetStore {
    static getBudget() {
        let budget;
        if (localStorage.getItem('budget') === null) {
            budget = [];
        } else {
            budget = JSON.parse(localStorage.getItem('budget'));
        }
        return budget;
    }

    static addBudget(budget) {
        const budgets = BudgetStore.getBudget();
        budgets.push(budget);
        localStorage.setItem('budget', JSON.stringify(budgets));
    }
}


document.addEventListener('DOMContentLoaded', () => {
    BudgetUI.budget = BudgetStore.getBudget();
    BudgetUI.displayBudget();
});


document.getElementById('budgetForm').addEventListener('submit', (e) => {
    e.preventDefault();

    const name = document.getElementById('dealName').value;
    const amount = parseFloat(document.getElementById('amount').value);

    const budget = new Budget(name, amount);

    BudgetUI.budget.push(budget);
    BudgetUI.displayBudget();

    BudgetStore.addBudget(budget);

    document.getElementById('budgetForm').reset();
});
