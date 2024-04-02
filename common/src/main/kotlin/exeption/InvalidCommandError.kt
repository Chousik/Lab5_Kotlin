package exeption


class InvalidCommandError(command: String) : Exception("InvalidCommandError: команда $command не найдена.")