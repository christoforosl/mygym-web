import React from 'react'

// from https://gist.github.com/JulianG/9aa3e0d299e0eb35637cd9d69540d4f9
export function createStrictContext<T>(
  options: {
    errorMessage?: string
    contextName?: string
  } = {}
) {
  const Context = React.createContext<T | undefined>(undefined)

  Context.displayName = options.contextName

  function useContext() {
    const context = React.useContext(Context)
    if (!context) {
      throw new Error(options.errorMessage || `${options.contextName || ''} Context Provider is missing`)
    }
    return context
  }

  return [Context.Provider, useContext] as [React.Provider<T>, () => T]
}

